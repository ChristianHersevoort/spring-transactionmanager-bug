package com.hersevoort.java.photon;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Christian Hersevoort
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ShouldHaveTransactionalImpl implements ShouldHaveTransactional {

    public String executeInTransaction() {
        return "Hi! from transaction";
    }
}
