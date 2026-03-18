/*
 * Copyright 2026 Treu Tech
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class CarbonFlowJob {
  public static void main(String[] args) {
    // Pseudocode only
    // Source 1: workload-events
    // Source 2: carbon-intensity-events
    // Join on region
    // Compute recommendation
    // Sink to optimization-signals
  }

  static OptimizationSignal evaluate(WorkloadEvent workload, CarbonIntensityEvent carbon) {
    if (workload.movable && carbon.carbonIntensity > 400.0 && workload.cpuRequest > 4.0) {
      return new OptimizationSignal(
          workload.jobId,
          workload.region,
          "move",
          "us-west-2",
          14.0,
          23.0,
          "High carbon intensity and high compute allocation",
          System.currentTimeMillis()
      );
    }

    return new OptimizationSignal(
        workload.jobId,
        workload.region,
        "run_now",
        workload.region,
        0.0,
        0.0,
        "Current execution is acceptable",
        System.currentTimeMillis()
    );
  }

  static class WorkloadEvent {
    String jobId;
    String region;
    double cpuRequest;
    boolean movable;
  }

  static class CarbonIntensityEvent {
    double carbonIntensity;
  }

  static class OptimizationSignal {
    String jobId;
    String currentRegion;
    String recommendedAction;
    String targetRegion;
    double estimatedCostSavingsPct;
    double estimatedCarbonReductionPct;
    String reason;
    long timestamp;

    OptimizationSignal(
        String jobId,
        String currentRegion,
        String recommendedAction,
        String targetRegion,
        double estimatedCostSavingsPct,
        double estimatedCarbonReductionPct,
        String reason,
        long timestamp
    ) {
      this.jobId = jobId;
      this.currentRegion = currentRegion;
      this.recommendedAction = recommendedAction;
      this.targetRegion = targetRegion;
      this.estimatedCostSavingsPct = estimatedCostSavingsPct;
      this.estimatedCarbonReductionPct = estimatedCarbonReductionPct;
      this.reason = reason;
      this.timestamp = timestamp;
    }
  }
}