export class Report {
  id: string;
  submissionId: string;
  refFileId: string;
  similarFileId: string;
  overallScore: number;
  md5Result: boolean;
  structureScore: number;
  loopScore: number;
  methodScore: number;
  winnowingScore: number;
}
