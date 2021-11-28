<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Recipient extends Model
{
    use HasFactory;

    protected $fillable = [
        'user_id',
        'hospital_name',
        'hospital_city',
        'phone',
        'blood_type',
        'blood_rhesus',
        'hospital_letter_path',
        'status',
    ];
}
