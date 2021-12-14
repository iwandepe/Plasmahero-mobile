<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Udd extends Model
{
    use HasFactory;
    protected $table = 'udds';
    protected $fillable = ['nama', 'alamat', 'link_map', 'jam', 'kontak', 'email'];
}
