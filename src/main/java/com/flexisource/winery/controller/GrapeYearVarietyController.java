package com.flexisource.winery.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "grapeYearVarietyController")
@ELBeanName(value = "grapeYearVarietyController")
@Join(path = "/grape/year/variety", to = "/wine/wine-grape-year-variety.jsf")
public class GrapeYearVarietyController {

}
