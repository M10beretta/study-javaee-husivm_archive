package com.mber.study.javaee.husivm._01_servlets._010_headers;

import com.mber.study.javaee.husivm._01_servlets.TestUtil;
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
