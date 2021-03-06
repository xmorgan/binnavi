/*
Copyright 2014 Google Inc. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.google.security.zynamics.binnavi.API.debug.raw;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.Lists;
import com.google.security.zynamics.binnavi.debug.models.targetinformation.RegisterValue;
import com.google.security.zynamics.binnavi.debug.models.targetinformation.ThreadRegisters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigInteger;

@RunWith(JUnit4.class)
public class RegisterValuesTest {
  @Test
  public void test() {
    final RegisterValues values = new RegisterValues(new com.google.security.zynamics.binnavi.debug.models.targetinformation.RegisterValues(Lists.<ThreadRegisters>newArrayList(new ThreadRegisters(55, Lists.newArrayList(new RegisterValue("eax", BigInteger.valueOf(0x123), new byte[10], false, true))))));
    assertEquals(1, values.getValues().size());
  }
}
