package com.mber.study.javaee.husivm._001_Servlets._008_UrlParameters;

import com.mber.study.javaee.husivm._001_Servlets.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class ServletTest {

    @Test
    public void run() {
        Assertions.assertTrue(TestUtil.connect("008?one=A&two=B&four=D&four=E"));
    }
}

