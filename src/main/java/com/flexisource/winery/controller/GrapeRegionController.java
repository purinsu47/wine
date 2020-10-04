package com.flexisource.winery.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "grapeRegionController")
@ELBeanName(value = "grapeRegionController")
@Join(path = "/grape/region", to = "/wine/wine-grape-region.jsf")
public class GrapeRegionController {

}
