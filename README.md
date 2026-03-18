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

# CarbonFlow

CarbonFlow is a real-time carbon-aware scheduler advisor for data pipelines built on Confluent Cloud.

It helps organizations reduce both infrastructure cost and carbon footprint by continuously analyzing workload changes, resource usage, and regional carbon intensity in real time.

## Problem

Data pipelines, ETL jobs, and batch workloads are often executed without considering real-time carbon intensity or compute efficiency. This leads to unnecessary cloud cost, wasted compute, and avoidable emissions.

## Solution

CarbonFlow uses Confluent Cloud to ingest workload changes from PostgreSQL CDC, combine them with carbon intensity data from external APIs, and process both streams with Apache Flink.

The system emits optimization recommendations such as:

- run now
- delay execution
- move to a lower-carbon region
- reduce compute allocation

## Architecture

1. PostgreSQL stores workload/job metadata
2. Postgres CDC Source Connector captures changes into Kafka
3. External carbon intensity data is ingested through a source connector
4. Apache Flink joins workload and carbon streams
5. Optimization signals are emitted to a Kafka topic
6. A sink connector persists recommendations for downstream systems

## Confluent Components Used

- Confluent Cloud Kafka
- PostgreSQL CDC Source Connector (Debezium)
- Source Connector for carbon intensity events
- Apache Flink
- Schema Registry
- Stream Governance
- Sink Connector for optimization results

## Example Output

```json
{
  "job_id": "etl_7821",
  "current_region": "us-east-1",
  "recommended_action": "move",
  "target_region": "us-west-2",
  "estimated_cost_savings_pct": 14,
  "estimated_carbon_reduction_pct": 23,
  "timestamp": 1742256000
}