import {inject, Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {CarResponse} from "../../dto/car.response";
import {Request} from "../../dto/request";
import {Response} from "../../dto/response";

@Injectable({providedIn: 'root'})
export class AiGateway {

    private httpclient = inject(HttpClient);

    postSpringQuestion(springRequest: Request): Observable<Response> {
        console.log("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return this.httpclient.post<Response>('http://localhost:8080/question', springRequest);
    }

    postInfoQuestion(infoRequest: Request): Observable<Response> {
        console.log("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return this.httpclient.post<Response>('http://localhost:8080/info', infoRequest);
    }

    postCarInfo(carInfo: string){
        return this.httpclient.post<CarResponse>(
            'http://localhost:8080/cars',
            null,
            {params: this.queryParams(carInfo)});
    }

    private queryParams (queryParam: string) {
        return new HttpParams()
            .set('car', queryParam);
    }


}
