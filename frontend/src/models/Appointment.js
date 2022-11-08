import { Patient } from "./Patient";
import { Schedule } from "./Schedule";
import { UBS } from "./UBS";

export class Appointment{

    id = Number;
    Appointment_status = String;
    schedule_id = Schedule;
    pacient_appointment = Patient;
    ubs_appointment = UBS;



}