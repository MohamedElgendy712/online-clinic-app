import { User } from "./user"

export class Review{

    constructor(doctor:User , reviewerName:string , rating: number, review: string, reviewDate: Date){
        this.doctor = doctor
        this.reviewerName = reviewerName
        this.rating = rating
        this.review = review
        this.reviewDate = reviewDate 
    }

    doctor : User
    reviewerName : string
    rating: number
    review: string
    reviewDate: Date
}