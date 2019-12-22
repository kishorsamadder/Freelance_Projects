export interface Jobs{
    active : Job,
    list: Job[]
}

export interface Job {
    jobId?:string; 
	jobTitle?:string;
	jobDescription?:string;
	jobCategory?:string;
}