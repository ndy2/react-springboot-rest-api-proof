import React, {useState} from "react";

export function SummaryItem({menuName}) {
    return (
        <React.Fragment>
            <div className="row">
                <h6 className="p-0">{menuName}</h6>
            </div>
        </React.Fragment>
    )
}