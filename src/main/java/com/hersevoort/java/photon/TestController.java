package com.hersevoort.java.photon;

import org.springframework.aop.framework.Advised;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * @author Christian Hersevoort
 */
@RequestMapping("/test")
@RestController
public class TestController
{
    @Inject
    private ShouldHaveTransactional shouldHaveTransactional;

    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld() {
        if(! hasTransactionalProxy()) {
            return "Fail, shouldHaveTransactional didn't get a transactional proxy!";
        }
        return String.format("Success, shouldHaveTransactional is transactional! : %s", shouldHaveTransactional.executeInTransaction());
    }

    private boolean hasTransactionalProxy() {
        return shouldHaveTransactional instanceof Advised;
    }
}
