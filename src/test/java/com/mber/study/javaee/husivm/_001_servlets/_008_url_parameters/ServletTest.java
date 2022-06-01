package com.mber.study.javaee.husivm._001_servlets._008_url_parameters;

import com.mber.study.javaee.husivm._001_servlets.TestUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
class ServletTest {

    @Test
    public void run() {
        assertTrue(TestUtil.connect("008?one=A&two=B&four=D&four=E"));
    }
}

