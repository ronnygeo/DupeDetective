import { InMemoryDbService } from 'angular-in-memory-web-api';
import {Assignment} from "./assignment";

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const assignments: Assignment[] = [
      { id: 1, name: 'Phase A', course: 'CS5500'},
      { id: 2, name: 'Phase B', course: 'CS5500'},
      { id: 3, name: 'Phase C', course: 'CS5500'},
      { id: 4, name: 'Homework 1', course: 'CS5500'},
      { id: 5, name: 'Homework 2', course: 'CS5500'},
      { id: 6, name: 'Crawling', course: 'CS5610'},
      { id: 7, name: 'Elasticsearch', course: 'CS5610'}
    ];
    return {assignments};
  }
}
