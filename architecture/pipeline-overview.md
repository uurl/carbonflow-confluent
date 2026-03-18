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

# CarbonFlow Pipeline Overview

## Data Flow

1. PostgreSQL stores workload metadata and scheduling changes
2. Postgres CDC Source Connector publishes workload events to Kafka
3. Carbon intensity data is ingested into Kafka from an external source
4. Apache Flink joins workload events with carbon intensity streams
5. Flink computes optimization recommendations
6. Results are written to an `optimization-signals` topic
7. A sink connector stores results in PostgreSQL or exposes them downstream

## Main Topics

- `workload-events`
- `carbon-intensity-events`
- `optimization-signals`

## Main Decisions

CarbonFlow emits real-time recommendations such as:
- move workload to another region
- delay execution
- reduce compute size
- flag inefficient execution