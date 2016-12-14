/*
 * Copyright 2016 Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#include <thrift/compiler/visitor.h>

#include <gmock/gmock.h>
#include <gtest/gtest.h>

using namespace apache::thrift::compiler;

namespace {

class InterleavedVisitorTest : public testing::Test {};

}

TEST_F(InterleavedVisitorTest, mixed) {
  struct tracking_visitor : visitor {
    tracking_visitor(bool ret) : ret_(ret) {}
    bool visit(t_program const*) override { return ret_; }
    bool visit(t_service const* const service) override {
      visited_services.push_back(service);
      return true;
    }
    std::vector<t_service const*> visited_services;
    bool ret_;
  };

  auto tv_f = tracking_visitor(false);
  auto tv_t = tracking_visitor(true);
  auto vtor = interleaved_visitor({&tv_f, &tv_t});

  auto program = t_program("path/to/module.thrift");
  auto service = t_service(&program);
  program.add_service(&service);
  vtor.traverse(&program);
  EXPECT_THAT(tv_f.visited_services, testing::ElementsAre());
  EXPECT_THAT(tv_t.visited_services, testing::ElementsAre(&service));
}
