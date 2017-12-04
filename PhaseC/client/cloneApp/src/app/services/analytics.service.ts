import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Prediction} from "../models/prediction";

// HTTP POST Options
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

/**
 * Analytics Service that performs all communication related to Analytics server
 */
@Injectable()
export class AnalyticsService {

  private predictUrl = 'http://localhost:3000/predict';
  private fitUrl = 'http://localhost:3000/fit';

  constructor(private http: HttpClient) { }

  /**
   * Get the prediction from server
   * @returns {Observable<Prediction>}
   */
  getPrediction(scores: number[]): Observable<Prediction> {
    const data = {"train": scores};
    return this.http.post<Prediction>(this.predictUrl, data);
  }

  /**
   * Train with the new data and get the prediction from server
   * @returns {Observable<Prediction>}
   */
  fitPredict(scores: number[], label: number): Observable<Prediction> {
    const data = {"train": scores, "label": label};
    return this.http.post<Prediction>(this.fitUrl, data);
  }
}
