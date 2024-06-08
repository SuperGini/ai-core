import {inject, Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {CarResponse} from "../../dto/car.response";
import {SpringRequest} from "../../dto/spring.request";
import {SpringResponse} from "../../dto/spring.response";

@Injectable({providedIn: 'root'})
export class AiGateway {

    private httpclient = inject(HttpClient);

    postSpringQuestion(springRequest: SpringRequest): Observable<SpringResponse> {
        console.log("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return this.httpclient.post<SpringResponse>('http://localhost:8080/question', springRequest);
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
