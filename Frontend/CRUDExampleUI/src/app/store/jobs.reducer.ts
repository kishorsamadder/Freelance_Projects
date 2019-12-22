import { JobsActions } from '../actions/jobs.actions';
import { Jobs } from '../model/jobs';

const INITIAL_STATE: Jobs = {
  list: [],
  active: {}
}

export function JobsReducer(state: Jobs = INITIAL_STATE, action: any): any {
  let index, active, list;

  switch (action.type) {
    case JobsActions.GET:
      return Object.assign({}, state, { list: action.payload.list });

    case JobsActions.GET_ACTIVE:
      return state.active;

    case JobsActions.DELETE:
      list = state.list
        .filter(({ jobId }) => jobId !== action.payload.jobId);
      return Object.assign({}, state, { list });

    case JobsActions.ADD:
      state.list.push(action.payload.job);
      return state;

    case JobsActions.UPDATE:
      list = [...state.list];
      index = list.findIndex(({ jobId }) => jobId === action.payload.job.jobId);
      list[index] = action.payload.job;
      return Object.assign({}, state, { list });

    case JobsActions.SET_ACTIVE:
      active = state.list.find(({jobId}) => jobId === action.payload.jobId);
      return Object.assign({}, state, { active });


    case JobsActions.RESET_ACTIVE:
      return Object.assign({}, state, { active: {} });

    default:
      return state;
  }
}

