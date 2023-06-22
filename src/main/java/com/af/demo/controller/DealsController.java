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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Controller
public class DealsController {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

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

        final ModelAndView modelAndView = new ModelAndView();

        logger.info("[Start Insert Deal]");

        if(dealsService.existsRecord(dealsRequest) != null){
            bindingResult.addError(new ObjectError("errors","deal already exists"));
            modelAndView.setViewName("deals");
            modelAndView.addObject("errors", bindingResult.getAllErrors());
            return modelAndView;
        }

        try {

            DealsEntity dealsEntity = new DealsEntity();
            BeanUtils.copyProperties(dealsRequest, dealsEntity);
            dealsEntity.setDealUniqueId(generateUniqueId.generateUniqueID(30));
            dealsEntity.setDealTimestamp(LocalDateTime.now());
            dealsService.saveDeal(dealsEntity);

            logger.debug("[SuccessSaveDeal] " + dealsRequest);

            if (bindingResult.hasErrors()) {
                modelAndView.addObject("errors", bindingResult.getAllErrors());
                logger.error("[SaveDealErrors] "+ bindingResult.getAllErrors());
            }

        }catch (DataIntegrityViolationException e){
            bindingResult.addError(new ObjectError("errors","exception deal already exists"));
            modelAndView.addObject("errors", bindingResult.getAllErrors());
        }

        modelAndView.setViewName("deals");
        return modelAndView;
    }

}
