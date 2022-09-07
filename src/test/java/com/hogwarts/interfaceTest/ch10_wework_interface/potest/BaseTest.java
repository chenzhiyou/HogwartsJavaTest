package com.hogwarts.interfaceTest.ch10_wework_interface.potest;

import com.hogwarts.interfaceTest.ch10_wework_interface.po.DepartApi;
import com.hogwarts.interfaceTest.ch10_wework_interface.po.MemberApi;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class BaseTest {
    public static final Logger logger = getLogger(lookup().lookupClass());
    public static DepartApi departApi;
    public static MemberApi memberApi;
    
    @BeforeAll
    public static void beforeALl(){
        departApi = new DepartApi();
        memberApi = new MemberApi();
    }

}
