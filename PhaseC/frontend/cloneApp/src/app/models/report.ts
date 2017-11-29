import {ModelReport} from "./modelreport";

/**
 * Class that maintains Report structure
 */
export class Report {
  id: string;
  submissionId: string;
  refFileId: string;
  similarFileId: string;
  overallScore: number;
  md5Result: boolean;
  models: ModelReport[];
}
