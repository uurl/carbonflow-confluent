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

# App Description

CarbonFlow is a real-time carbon-aware scheduler advisor for data pipelines.

It captures workload changes from PostgreSQL using CDC, enriches them with real-time carbon intensity signals, and processes both streams using Apache Flink.

The application generates optimization recommendations to reduce cloud cost and carbon footprint, such as delaying execution, moving jobs to lower-carbon regions, or reducing compute allocation.