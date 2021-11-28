<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Donor extends Model
{
    use HasFactory;

    protected $fillable = [
        'user_id',
        'address',
        'city',
        'age',
        'phone',
        'gender',
        'blood_type',
        'blood_rhesus',
        'weight',
        'negative_test_date',
        'treatment',
        'symptom',
        'is_tranfusion',
        'is_vaccinated',
        'vaccine_name',
        'vaccine_dose',
        'is_donate_regularly',
        'is_contact_shareable',
        'is_voluntary',
        'negative_evidence_path',
        'positive_evidence_path',
        'chronic_disease',
        'status',
    ];
}
