import { Injectable } from '@angular/core';
import { IAppState } from '../store/index';
import { NgRedux } from '@angular-redux/store';
import { Http } from '@angular/http';
import { Job } from '../model/jobs'

@Injectable()
export class JobsActions {
  static GET = 'GET';
  static ADD = 'ADD';
  static UPDATE = 'UPDATE';
  static DELETE = 'DELETE';
  static GET_ACTIVE = 'GET_ACTIVE';
  static SET_ACTIVE = 'SET_ACTIVE';
  static RESET_ACTIVE = 'RESET_ACTIVE';

  API_URL = 'http://localhost:8080/api/v1/job'

  constructor(
    private ngRedux: NgRedux<IAppState>,
    private http: Http,
  ) {
  }

  getJobs() {
    this.http.get(`${this.API_URL}`)
      .subscribe((res) => {
        // get jobs
        const list = res.json().data;
        // populate jobs state (dispatch action)
        this.ngRedux.dispatch({
          type: JobsActions.GET,
          payload: {
            list
          }
        });
        // Set the first job as active (dispatch action)
        this.setActive(list[0].id);
      });
  }

  save(job: Job) {
    if (job.jobId) {
      this.update(job);
    } else {
      this.add(job);
    }
  }

  add(job: Job): void {
    this.http.post(`${this.API_URL}`, job)
      .subscribe((res) => {
        // add new job
        this.ngRedux.dispatch({
          type: JobsActions.ADD,
          payload: { job: res.json().data }
        });

        // select last added job
        this.setActive(res.json().id);
      });
  }

  update(job: Job) {
    this.http.patch(`${this.API_URL}/${job.jobId}`, job)
      .subscribe((res) => {
        // update job
        this.ngRedux.dispatch({
          type: JobsActions.UPDATE,
          payload: { job: res.json().data }
        });

        // update active job
        this.setActive(job.jobId);
      });
  }

  delete(jobId): void {
    this.http.delete(`${this.API_URL}/${jobId}`)
      .subscribe((res) => {
        this.ngRedux.dispatch({
          type: JobsActions.DELETE,
          payload: { jobId }
        });
        this.resetActive();
      });
  }

  setActive(jobId: string): void {
    this.ngRedux.dispatch({
      type: JobsActions.SET_ACTIVE,
      payload: { jobId }
    });
  }

  resetActive(): void {
    this.ngRedux.dispatch({
      type: JobsActions.RESET_ACTIVE,
      payload: null
    });
  }
}
