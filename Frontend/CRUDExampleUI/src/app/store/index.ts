import { combineReducers } from 'redux';

import { JobsReducer } from './jobs.reducer';
import { Jobs } from '../model/jobs';

export class IAppState {
  jobs : Jobs
};

export const rootReducer = combineReducers<IAppState>({
  jobs: JobsReducer,
});


