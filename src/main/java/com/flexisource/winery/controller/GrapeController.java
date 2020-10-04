package com.flexisource.winery.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "grapeController")
@ELBeanName(value = "grapeController")
@Join(path = "/grape", to = "/wine/wine-grape.jsf")
public class GrapeController {

}
