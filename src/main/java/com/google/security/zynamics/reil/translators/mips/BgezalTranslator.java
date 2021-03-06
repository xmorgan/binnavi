// Copyright 2011-2016 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.security.zynamics.reil.translators.mips;

import com.google.security.zynamics.reil.OperandSize;
import com.google.security.zynamics.reil.ReilHelpers;
import com.google.security.zynamics.reil.ReilInstruction;
import com.google.security.zynamics.reil.translators.IInstructionTranslator;
import com.google.security.zynamics.reil.translators.ITranslationEnvironment;
import com.google.security.zynamics.reil.translators.InternalTranslationException;
import com.google.security.zynamics.reil.translators.TranslationHelpers;
import com.google.security.zynamics.zylib.disassembly.IInstruction;
import com.google.security.zynamics.zylib.disassembly.IOperandTree;
import com.google.security.zynamics.zylib.disassembly.IOperandTreeNode;

import java.util.List;


public class BgezalTranslator implements IInstructionTranslator {

  @Override
  public void translate(final ITranslationEnvironment environment, final IInstruction instruction,
      final List<ReilInstruction> instructions) throws InternalTranslationException {
    TranslationHelpers.checkTranslationArguments(environment, instruction, instructions, "bgezal");
    final List<? extends IOperandTree> operands = instruction.getOperands();

    final String rs = operands.get(0).getRootNode().getChildren().get(0).getValue();
    final IOperandTreeNode target = operands.get(1).getRootNode().getChildren().get(0);

    final OperandSize dw = OperandSize.DWORD;

    final long baseOffset = ReilHelpers.toReilAddress(instruction.getAddress()).toLong();
    long offset = baseOffset;

    final String rsOnesComplement = environment.getNextVariableString();
    final String jumpCondition = environment.getNextVariableString();

    instructions.add(ReilHelpers.createXor(offset++, dw, rs, dw, String.valueOf(0xFFFFFFFFL), dw,
        rsOnesComplement));
    instructions.add(ReilHelpers.createBsh(offset++, dw, rsOnesComplement, dw,
        String.valueOf(-31L), dw, jumpCondition));

    Helpers.generateDelayBranch(instructions, offset, dw, jumpCondition, dw, target);
  }
}
