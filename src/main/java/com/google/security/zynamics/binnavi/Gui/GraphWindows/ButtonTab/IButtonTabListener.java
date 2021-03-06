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

package com.google.security.zynamics.binnavi.Gui.GraphWindows.ButtonTab;

/**
 * Interface that must be implemented by classes that want to be notified about buttoned tab panels
 * that are about to be closed.
 */
public interface IButtonTabListener {
  /**
   * Invoked right before a tab component is closed because the user clicked on the X button to
   * close the tab.
   *
   * @param component The component that is about to be closed.
   *
   * @return True, to allow the tab to be closed. False, to keep it open.
   */
  boolean closing(ButtonTabComponent component);
}
