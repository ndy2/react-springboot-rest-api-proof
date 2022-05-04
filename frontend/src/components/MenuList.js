import React, {useState} from "react";
import {Menu} from "./Menu";

export function MenuList({menus = [], onAddClick}) {

    return (
        <React.Fragment>
            <div>
                <table className="table">
                    <tbody>
                    {menus.map(v =>
                        <tr key={v.id}>
                            <td>
                                <Menu {...v} onAddClick = {onAddClick}/>
                            </td>
                        </tr>
                    )}
                    </tbody>
                </table>
            </div>
        </React.Fragment>
    )
}