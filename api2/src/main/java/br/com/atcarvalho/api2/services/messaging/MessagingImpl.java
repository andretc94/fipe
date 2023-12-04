package br.com.atcarvalho.api2.services.messaging;

import br.com.atcarvalho.api2.models.Model;
import br.com.atcarvalho.api2.services.BrandService;
import br.com.atcarvalho.api2.services.ModelService;
import br.com.atcarvalho.api2.services.fipe.FipeFeignClient;
import br.com.atcarvalho.api2.services.fipe.dtos.Brand;
import br.com.atcarvalho.api2.services.fipe.dtos.Root;
import br.com.atcarvalho.api2.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class MessagingImpl implements Messaging {

    private RabbitTemplate rabbitTemplate;

    private Queue queue;

    private FipeFeignClient fipeFeignClient;

    private BrandService brandService;

    private ModelService modelService;
    public MessagingImpl(RabbitTemplate rabbitTemplate, Queue queue, FipeFeignClient fipeFeignClient, BrandService brandService, ModelService modelService) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
        this.fipeFeignClient = fipeFeignClient;
        this.brandService = brandService;
        this.modelService = modelService;
    }

    @Override
    public void send(String message) {
        rabbitTemplate.convertAndSend(this.queue.getName(), message);
    }

    @Override
    @RabbitListener(queues = "BRANDS")
    public void load(String message) {
        log.info("read from queue: {}", message);
        Brand brand = Utils.toClass(message, Brand.class);
        br.com.atcarvalho.api2.models.Brand brandEntity = brandService.save(brand);

        Root model = fipeFeignClient.getModels(String.valueOf(brand.codigo()));

        List<Model> models = convertToEntity(model, brandEntity);

        modelService.save(models);

//        Thread.sleep(1000 * 10);
    }

    private static List<Model> convertToEntity(Root model, br.com.atcarvalho.api2.models.Brand save) {
        return model.modelos.stream().map(it -> {
            Model model1 = new Model();
            model1.setId((long) it.codigo);
            model1.setName(it.nome);
            model1.setBrand(save);
            return model1;
        }).toList();
    }
}
