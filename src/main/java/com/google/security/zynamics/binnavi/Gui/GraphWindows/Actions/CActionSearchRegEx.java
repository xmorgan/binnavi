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

package com.google.security.zynamics.binnavi.Gui.GraphWindows.Actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.google.security.zynamics.binnavi.Gui.GraphWindows.Implementations.CGraphSearcher;
import com.google.security.zynamics.binnavi.yfileswrap.zygraph.ZyGraph;


/**
 * Action used to toggle between regular expression search settings.
 */
public final class CActionSearchRegEx extends AbstractAction {
  /**
   * Used for serialization.
   */
  private static final long serialVersionUID = 718365426880741025L;

  /**
   * Graph whose setting is toggled.
   */
  private final ZyGraph m_graph;

  /**
   * Creates a new action object.
   *
   * @param graph Graph whose setting is toggled.
   */
  public CActionSearchRegEx(final ZyGraph graph) {
    super("Regular Expression Search");

    m_graph = graph;
  }

  @Override
  public void actionPerformed(final ActionEvent event) {
    CGraphSearcher.toggleRegularExpressionSearch(m_graph);
  }
}
