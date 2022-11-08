import { Doctor } from "./Doctor";

export class Schedule{

    id = Number;
    condition = String;
    day_schedule = Date;
    hr_end = Date;
    hr_ini = Date;
    doc_schedule = Doctor;

}