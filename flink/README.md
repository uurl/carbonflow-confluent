<!--
Copyright 2026 Treu Tech

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
-->

# Flink Logic

CarbonFlow uses Apache Flink to join workload changes with real-time carbon intensity data.

## Core logic

- Read workload changes from `workload-events`
- Read carbon signals from `carbon-intensity-events`
- Join by region
- Compute whether the job should:
    - run now
    - be delayed
    - move to another region
    - reduce compute allocation

## Output

Write optimization recommendations to `optimization-signals`