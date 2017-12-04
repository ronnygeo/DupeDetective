import {ReportLine} from "./reportline";

/**
 * Class that maintains Single Model result from the report
 */
export class ModelReport {
  model: number;
  score: number;
  lines: ReportLine[];
}
