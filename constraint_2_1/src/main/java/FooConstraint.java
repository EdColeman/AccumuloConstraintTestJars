/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.accumulo.core.data.constraints.Constraint;
import org.apache.accumulo.core.data.Mutation;

import java.util.Collections;
import java.util.List;

public class FooConstraint
    implements Constraint {
  public String getViolationDescription(short violationCode) {
    switch (violationCode) {
      case 1:
        return "Contains foo";
    }
    throw new IllegalArgumentException();
  }

  public List<Short> check(Constraint.Environment env, Mutation mutation) {
    if (new String(mutation.getRow()).contains("foo")) {
      return Collections.singletonList(Short.valueOf("1"));
    }

    return null;
  }
}
