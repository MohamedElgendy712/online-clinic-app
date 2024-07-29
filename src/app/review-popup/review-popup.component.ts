import { Component, inject, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ReviewServ } from '../services/review.service';

@Component({
    selector: 'app-review-popup',
    templateUrl: './review-popup.component.html',
    styleUrl: './review-popup.component.css'
})
export class ReviewPopUp {

    @ViewChild('registrationForm') form: NgForm;

    reviewServ : ReviewServ = inject(ReviewServ)

    onFormSubmitted() {
        this.reviewServ.addReview(this.form.value.rating , this.form.value.review).subscribe({
            next: (res)=>{
                this.reviewServ.toggelReviewPopup()
            }
        })
    }

    onCancel(){
        this.reviewServ.toggelReviewPopup()
    }

}
