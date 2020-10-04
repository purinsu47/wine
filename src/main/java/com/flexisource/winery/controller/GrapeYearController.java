package com.flexisource.winery.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "grapeYearController")
@ELBeanName(value = "grapeYearController")
@Join(path = "/grape/year", to = "/wine/wine-grape-year.jsf")
public class GrapeYearController {

}
