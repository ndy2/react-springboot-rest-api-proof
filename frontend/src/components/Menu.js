import React, {useState} from "react";
import {Options} from "./Options";

export function Menu(props) {

    const name = props.name;
    const price = props.price;
    const imageUrl = props.imageUrl;
    const options = props.options;

    return (
        <React.Fragment>
            <img src={imageUrl} alt="빅맥"/>
            <div> {name}</div>
            <div> {price} 원</div>
            <Options options={options}/>
            <div className="col text-end action"><a className="btn btn-small btn-outline-dark" href="">추가</a></div>
        </React.Fragment>
    )
}