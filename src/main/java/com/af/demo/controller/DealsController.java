package com.af.demo.controller;

import com.af.demo.DemoApplication;
import com.af.demo.entities.DealsEntity;
import com.af.demo.model.request.DealsRequest;
import com.af.demo.service.DealsService;
import com.af.demo.utils.IGenerateUniqueId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Controller
public class DealsController {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    private Set<String> processedRequests = new HashSet<>();

    @Autowired
    private DealsService dealsService;
    @Autowired
    private IGenerateUniqueId generateUniqueId;

    @GetMapping("/")
    public String dealsPage(Model model) {
        return "deals";
    }

    @RequestMapping(value = "/save-deal", method = RequestMethod.POST)
    public ModelAndView saveDealController(@Validated DealsRequest dealsRequest, BindingResult bindingResult) {

        String generateId = generateUniqueId.generateUniqueID(30);
        final ModelAndView modelAndView = new ModelAndView();

        if (processedRequests.contains(generateId)) {
            logger.error("[Duplicate Request]");
            modelAndView.addObject("errors", "duplicate request");
            modelAndView.setViewName("deals");
            return modelAndView;
        }

        logger.info("[Start Insert Deal]");
        processedRequests.add(generateId);

        try {

            DealsEntity dealsEntity = new DealsEntity();
            BeanUtils.copyProperties(dealsRequest, dealsEntity);
            dealsEntity.setDealUniqueId(generateId);
            dealsEntity.setDealTimestamp(LocalDateTime.now());
            dealsService.saveDeal(dealsEntity);
            logger.debug("[SuccessSaveDeal]", dealsRequest);

            if (bindingResult.hasErrors()) {
                modelAndView.addObject("errors", bindingResult.getAllErrors());
                logger.error("[SaveDeal]", bindingResult.getAllErrors());
            }

        }catch (Exception e){
            modelAndView.addObject("errors", bindingResult.getAllErrors());
            logger.error("[SaveDealException]", e.getMessage());
        }

        modelAndView.setViewName("deals");
        return modelAndView;
    }

}
