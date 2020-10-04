package com.flexisource.winery.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "grapeVarietyController")
@ELBeanName(value = "grapeVarietyController")
@Join(path = "/grape/variety", to = "/wine/wine-grape-variety.jsf")
public class GrapeVarietyController {

}
