package com.mber.study.javaee.husivm._001_Servlets._010_Headers;

import com.mber.study.javaee.husivm._001_Servlets.TestUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
class ServletTest {

    @Test
    public void run() {
        assertTrue(TestUtil.connect("010"));
    }
}
