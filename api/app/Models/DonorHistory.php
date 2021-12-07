<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class DonorHistory extends Model
{
    use HasFactory;

    protected $fillable = [
        'user_id',
        'udd',
        'donor_date',
        'donor_evidence_path',
        'is_valid',
    ];
}
