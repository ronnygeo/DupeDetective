import { InMemoryDbService } from 'angular-in-memory-web-api';
import {Assignment} from "../models/assignment";
import {Submission} from "../models/submission";
import {User} from "../models/user";
import {Report} from "../models/report";

/**
 * The in memory data service that provides mock data
 */
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

    const submissions: Submission[] = [
      {id: 1, name: "final", userId: 1, assignmentId: 1, submittedOn: "11/15/2017 11:00 PM"},
      {id: 2, name: "final", userId: 2, assignmentId: 1, submittedOn: "11/14/2017 11:00 PM"},
      {id: 3, name: "final", userId: 3, assignmentId: 1, submittedOn: "11/16/2017 11:00 PM"},
      {id: 4, name: "final", userId: 1, assignmentId: 2, submittedOn: "11/20/2017 11:00 PM"},
      {id: 5, name: "final", userId: 2, assignmentId: 2, submittedOn: "11/21/2017 11:00 PM"},
    ];

    const files = [];

    const users: User[] = [
      {id: 1, name: "Ronny", username: "ronny", password: "12345", grader: false},
      {id: 1, name: "Joyal", username: "joyal", password: "12345", grader: false},
      {id: 1, name: "Shalin", username: "shalin", password: "12345", grader: false},
      {id: 1, name: "Nikhila", username: "nikhila", password: "12345", grader: false},
      {id: 1, name: "Bob", username: "bob", password: "12345", grader: true}
    ];

    const reports: Report[] = [];
    return {users, assignments, submissions, files, reports};
  }
}
