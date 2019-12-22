import { Component, Pipe, PipeTransform, ViewChild } from '@angular/core';
import { select } from '@angular-redux/store';
import { Observable, from } from 'rxjs';

import { JobsActions } from './actions/jobs.actions';
import { Jobs } from './model/jobs';
import { FilterPipe } from './actions/filter.pipe'

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  { 
  @select('jobs') public jobs$: Observable<Jobs>;
  @select(['jobs', 'active']) active$;
  activeJob;

  constructor(public actions:  JobsActions) {
    actions.getJobs();
  }


  ngOnInit() {
    this.active$.subscribe(res => {
      this.activeJob = res ;
    });
  }

   save(f: any) {
    // Merge form data with data model
    // (since form does not include all fields)
    const newJob = Object.assign({}, this.activeJob, f.value);
    this.actions.save(newJob);
  }

}