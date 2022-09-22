import React, {useState,UseEffect} from 'react'
import { useEffect } from 'react';


const gradientTransform = `rotate(90)`;
export const GradientSVG = ({id,cor1,cor2}) => {
  return (
    <svg style={{ height: 0 }}>
      <defs>
        <linearGradient id={id} gradientTransform={gradientTransform}>
          <stop offset="16.29%" stopColor= {"#4A2FBD"}  />
          <stop offset="85.56%" stopColor= {"#AA367C"} />
        </linearGradient>
      </defs>
    </svg>
  );
}
  
