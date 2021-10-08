package com.yjl.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yujiale
 */
@Controller
public class CommonHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/common/request/one")
    public String one() {

        logger.debug("common request one");

        return "target";
    }

    @RequestMapping("/common/request/two")
    public String two() {

        logger.debug("common request two");

        return "target";
    }

    @RequestMapping("/common/request/two/aaa")
    public String twoAAA() {

        logger.debug("common request two");

        return "target";
    }

    @RequestMapping("/common/request/two/bbb")
    public String twoBBB() {

        logger.debug("common request two");

        return "target";
    }

    @RequestMapping("/common/request/two/bbb/111")
    public String twoBBB111() {

        logger.debug("common request two 111");

        return "target";
    }

    @RequestMapping("/common/request/two/bbb/222")
    public String twoBBB222() {

        logger.debug("common request two 222");

        return "target";
    }

    @RequestMapping("/common/request")
    public String twoBBB000() {

        logger.debug("common request 000");

        return "target";
    }
}
